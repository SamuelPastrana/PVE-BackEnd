package com.pve.pvebackend.services.inversion;

import com.pve.pvebackend.model.inversion.Inversion;
import com.pve.pvebackend.repository.inversion.InversionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
class InversionService implements IServiceInversion {

    @Autowired
    private InversionRepository repository;

    InversionService(InversionRepository repo){
        this.repository = repo;
    }

    @NotNull
    @Override
    public List<Inversion> obtenerInversiones() {
        return repository.findAll();
    }
}

