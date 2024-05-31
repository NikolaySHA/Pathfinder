package softuni.pathfinder.service;

import softuni.pathfinder.service.dto.RouteShortDTO;

import java.util.List;

public interface RouteService {
    public RouteShortDTO getRandomRoute();
    public List<RouteShortDTO> getAll();
}
