package com.genspark.Assignment2.a.services;

import com.genspark.Assignment2.a.entity.ProWrestler;
import com.genspark.Assignment2.a.requests.ProWrestlerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProWrestlerService {

    @Autowired
    private ProWrestlerRepository repo;

    public List<ProWrestler> listAll() {
        return repo.findAll();
    }

    public ProWrestler get(Integer id) {
        return repo.findById(id).get();
    }

    public List<ProWrestler> getByName(String name) {
        List<ProWrestler> list = new ArrayList<>();
        for(ProWrestler p: repo.findAll()) {
            if(p.getRealName().toLowerCase().contains(name.toLowerCase())) list.add(p);
            if(p.getRingName().toLowerCase().contains(name.toLowerCase())) list.add(p);
        }
        return list;
    }

    public List<ProWrestler> getByFinisher(String finisher) {
        List<ProWrestler> list = new ArrayList<>();
        for(ProWrestler p: repo.findAll()) {
            if(p.getFinisher().toLowerCase().contains(finisher.toLowerCase())) list.add(p);
        }
        return list;
    }

    public List<ProWrestler> getActiveProWrestlers() {
        List<ProWrestler> list = new ArrayList<>();
        for(ProWrestler p: repo.findAll()) {
            if(p.isActive()) list.add(p);
        }
        return list;
    }

    public List<ProWrestler> getInactiveProWrestlers() {
        List<ProWrestler> list = new ArrayList<>();
        for(ProWrestler p: repo.findAll()) {
            if(!p.isActive()) list.add(p);
        }
        return list;
    }

    public ProWrestler editRingName(ProWrestlerRequest proWrestlerRequest, int id) {
        ProWrestler p = repo.findById(id).get();
        p.setRingName(proWrestlerRequest.getRingName());
        return repo.save(p);
    }

    public ProWrestler editFinisher(ProWrestlerRequest proWrestlerRequest, int id) {
        ProWrestler p = repo.findById(id).get();
        p.setFinisher(proWrestlerRequest.getFinisher());
        return repo.save(p);
    }

    public ProWrestler editActiveStatus(ProWrestlerRequest proWrestlerRequest, int id) {
        ProWrestler p = repo.findById(id).get();
        p.setActive(proWrestlerRequest.isActive());
        return p;
    }

    public ProWrestler addNewProWrestler(ProWrestlerRequest proWrestlerRequest) {
        ProWrestler p = new ProWrestler();
        p.setRingName(proWrestlerRequest.getRingName());
        p.setRealName(proWrestlerRequest.getRealName());
        p.setFinisher(proWrestlerRequest.getFinisher());
        return repo.save(p);
    }

    public ProWrestler addNewProWrestler(ProWrestlerRequest proWrestlerRequest, boolean active) {
        ProWrestler p = new ProWrestler();
        p.setRingName(proWrestlerRequest.getRingName());
        p.setRealName(proWrestlerRequest.getRealName());
        p.setFinisher(proWrestlerRequest.getFinisher());
        p.setActive(active);
        repo.save(p);
        return p;
    }

    public void deleteProWrestler(int id) {
        repo.deleteById(id);
    }
}
