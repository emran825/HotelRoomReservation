/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emran.hotelroomreservation.dao;

import com.emran.hotelroomreservation.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author SARK
 */
@Service
public interface UserService {
    public String addUser(User user);
    public String updateUser(User user);
    public String deleteUser(String id);
    public String viewAllUser();
    public User viewUser(String id);
}
