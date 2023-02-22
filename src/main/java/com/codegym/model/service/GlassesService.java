package com.codegym.model.service;

import com.codegym.model.dao.GlassesDAO;
import com.codegym.model.dto.GlassesDTO;
import com.codegym.model.entity.Glasses;

import java.util.ArrayList;
import java.util.List;

public class GlassesService {
    private GlassesDAO glassesDAO = null;
    public GlassesService(){
        glassesDAO = new GlassesDAO();
    }

    public List<GlassesDTO> findAll() {
        List<Glasses> glassesList = glassesDAO.getAll();
        List<GlassesDTO> glassesDTO = new ArrayList<>();
        for(Glasses glasses : glassesList){
            GlassesDTO glassesDTO1 = new GlassesDTO(glasses.getId(), glasses.getName(), glasses.getPrice(),
                    glasses.getQuantity(), glasses.getBrand());
            glassesDTO.add(glassesDTO1);
        }
        return glassesDTO;
    }


    public void save(GlassesDTO glassesDTO) {
        Glasses glasses = new Glasses(glassesDTO.getId(), glassesDTO.getName(), glassesDTO.getPrice(),
                glassesDTO.getQuantity(), glassesDTO.getBrand());
        glassesDAO.insert(glasses);
    }


    public GlassesDTO findById(int id) {
        return glassesDAO.get(id);
    }


    public void edit( int id, GlassesDTO glassesDTO) throws Exception {
        Glasses glasses = new Glasses(glassesDTO.getId(), glassesDTO.getName(), glassesDTO.getPrice(),
                glassesDTO.getQuantity(), glassesDTO.getBrand());
        glassesDAO.update(id, glasses);
    }
    public void remove(int id) {
        glassesDAO.delete(id);
    }
}
