/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.Facility;
import org.springframework.stereotype.Service;

/**
 *
 * @author B2
 */
@Service
public interface FacilityService {
    public String addFacility(Facility facility);
    public String updateFacility(Facility facility);
    public String deleteFacility(int id);
    public String viewAllFacility();
    public Facility viewFacility(int id);
    
}
