package org.cerner.multiplex.packageinfo.resource;


import java.util.List;

import org.cerner.multiplex.packageinfo.dao.RatingDetailsDAO;
import org.cerner.multiplex.packageinfo.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemRatingResource {

    @Autowired
    private RatingDetailsDAO<Integer, UserRating> hospitalDAO;

    @PostMapping("/rating")
    public ResponseEntity<List<UserRating>> add(@RequestBody List<UserRating> ratings)
    {
        for(UserRating rating : ratings)
            hospitalDAO.add(rating.getId(), rating);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }

    @GetMapping("/rating/{id}")
    ResponseEntity<UserRating> get(@PathVariable("id") String id)
    {
        int key = Integer.parseInt(id);
        return ResponseEntity.status(HttpStatus.OK).body(hospitalDAO.get(key));
    }

    @PutMapping("/rating")
    public ResponseEntity<UserRating> update(@RequestBody UserRating hospital)
    {
        hospitalDAO.addOrUpdate(hospital.getId(), hospital);
        return new ResponseEntity<>(hospital, HttpStatus.OK);
    }

    @DeleteMapping(value = "/rating/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        int key = Integer.parseInt(id);
        boolean isRemoved = hospitalDAO.remove(key);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
