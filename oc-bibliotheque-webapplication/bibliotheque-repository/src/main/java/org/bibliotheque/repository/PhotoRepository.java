package org.bibliotheque.repository;

import org.bibliotheque.client.PhotoClient;
import org.bibliotheque.wsdl.GetAllPhotosResponse;
import org.bibliotheque.wsdl.GetPhotoByIdResponse;
import org.bibliotheque.wsdl.PhotoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoRepository {


    @Autowired
    private PhotoClient client;

    /**
     * ==== GET PHOTO BY ID ====
     * @param id
     * @return PhotoType
     * @see PhotoClient#getPhotoById(Integer)
     */
   public PhotoType photoById(Integer id){
       GetPhotoByIdResponse response = client.getPhotoById(id);
       return response.getPhotoType();
   }

    /**
     * ==== GET ALL PHOTOS ====
     * @return List PhotoType
     * @see PhotoClient#getAllPhotos()
     */
    public List<PhotoType> photoTypeList(){
        GetAllPhotosResponse response = client.getAllPhotos();
        return response.getPhotoType();
    }
}
