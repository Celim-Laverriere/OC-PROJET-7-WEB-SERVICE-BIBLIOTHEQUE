package org.bibliotheque.service;

import org.bibliotheque.entity.LivreEntity;

import java.util.List;

public interface LivreService {

   LivreEntity getLivreById(Integer id);
   List<LivreEntity> getAllLivres();
}
