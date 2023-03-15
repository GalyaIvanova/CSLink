
package com.server.jwt.controller;

//        import com.server.jwt.entity.MedicalPractitioner;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.jwt.models.supporting.MedicAddRequests;
import com.server.jwt.service.MedicService;

@RestController
public class RelationController {

    @Autowired
    private MedicService medicService;

    @PostMapping({ "/editPatientDoctorSet" })
    @PreAuthorize("hasRole(1)")
    public String editPatientDoctorSet(@RequestBody MedicAddRequests medicAddRequests) throws SQLIntegrityConstraintViolationException {
        return medicService.editPatientDoctorSet(medicAddRequests.getMedicId(), medicAddRequests.getRequests());
/*
        {
            "medicId":0,

                "requests":[
                    {
                        "userName":"..."
                    }
                ,
                    {
                        "userName":".."
                    }
                ,   ...
        }
*/
    }
}