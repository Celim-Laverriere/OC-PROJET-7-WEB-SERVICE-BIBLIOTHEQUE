package org.bibliotheque.service;

import org.bibliotheque.client.PhotoClient;
import org.bibliotheque.repository.PhotoRepository;
import org.bibliotheque.wsdl.PhotoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {


    @Autowired
    private PhotoRepository repository;

    /**
     * GET PHOTO BY ID
     * @param id @return PhotoType
     * @see PhotoClient#getPhotoById(Integer)
     */
    public PhotoType photoById(Integer id){
        return repository.photoById(id);
    }

    /**
     * GET ALL PHOTOS
     * @return photoTypeList
     * @see PhotoClient#getAllPhotos()
     */
    public List<PhotoType> photoTypeList(){
        return repository.photoTypeList();
    }
}
