package edu.sanvalero.starwarslibrary.ships;

import edu.sanvalero.starwarslibrary.ships.dto.ShipInDto;
import edu.sanvalero.starwarslibrary.ships.dto.ShipOutDto;
import edu.sanvalero.starwarslibrary.ships.exception.ShipInvalidPatchParameterException;
import edu.sanvalero.starwarslibrary.ships.exception.ShipNotFoundException;
import edu.sanvalero.starwarslibrary.ships.model.Ship;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ShipOutDto> get() {
        List<Ship> ships = shipRepository.findAll();
        List<ShipOutDto> out = getShipOutDtos(ships);
        return out;
    }

    @Override
    public ShipOutDto get(long id) {
        return getShipOutDto(getShipOrFail(id));
    }

    @Override
    public ShipOutDto post(ShipInDto shipInDto) {
        Ship newShip = new Ship();
        modelMapper.map(shipInDto, newShip);
        shipRepository.save(newShip);
        return getShipOutDto(newShip);
    }

    @Override
    public ShipOutDto put(long id, ShipInDto shipInDto) {
        Ship ship = getShipOrFail(id);
        modelMapper.map(shipInDto, ship);
        shipRepository.save(ship);
        return getShipOutDto(ship);
    }

    @Override
    public ShipOutDto patch(long id, Map<String, Object> patchParameters) {
        Ship ship = getShipOrFail(id);
        patchParameters.forEach((key, value) -> {
            switch (key) {
                case "name":
                    ship.setName(String.valueOf(value));
                    break;
                case "model":
                    ship.setModel(String.valueOf(value));
                    break;
                case "constructor":
                    ship.setConstructor(String.valueOf(value));
                    break;
                case "length":
                    ship.setLength(Float.parseFloat(String.valueOf(value)));
                    break;
                default:
                    throw new ShipInvalidPatchParameterException(key);
            }
        });
        shipRepository.save(ship);
        return getShipOutDto(ship);
    }

    @Override
    public void delete(long id) {
        getShipOrFail(id);
        shipRepository.deleteById(id);
    }

    private Ship getShipOrFail(long id) {
        return shipRepository.findById(id).orElseThrow(() -> new ShipNotFoundException(id));
    }

    private ShipOutDto getShipOutDto(Ship ship) {
        ShipOutDto out = new ShipOutDto();
        modelMapper.map(ship, out);
        return out;
    }

    private List<ShipOutDto> getShipOutDtos(List<Ship> ships) {
        List<ShipOutDto> out = new ArrayList<>();
        ships.forEach(ship -> out.add(getShipOutDto(ship)));
        return out;
    }
}
