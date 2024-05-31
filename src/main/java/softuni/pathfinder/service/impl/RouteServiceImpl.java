package softuni.pathfinder.service.impl;


import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.pathfinder.model.Picture;
import softuni.pathfinder.model.Route;
import softuni.pathfinder.service.RouteService;
import softuni.pathfinder.service.dto.RouteShortDTO;
import softuni.pathfinder.service.repo.RouteRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private ModelMapper modelMapper;
    
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
    }
    
    @Override
    @Transactional
    public RouteShortDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = new Random().nextLong(routeCount) + 1;
        Route byId = this.routeRepository.findById(randomId).get();
        return  mapToShort(byId);
    }
    
    @Override
    @Transactional
    public List<RouteShortDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::mapToShort)
                .toList();
    }
    
    private RouteShortDTO mapToShort(Route route) {
        RouteShortDTO dto = modelMapper.map(route, RouteShortDTO.class);
        Optional<Picture> picture = route.getPictures().stream().findFirst();
        dto.setImageUrl(picture.get().getUrl());
        return dto;
    }
}
