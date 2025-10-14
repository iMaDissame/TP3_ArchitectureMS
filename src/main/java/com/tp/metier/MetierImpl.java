package com.tp.metier;

import com.tp.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component("metier")
public class MetierImpl implements IMetier {

    @Autowired
//    @Qualifier("dao2") // Spécifie quel Implementation (bean) doit être injecté
    private IDao dao;  // Par défaut, Spring injectera le premier bean compatible trouvé

    @Override
    public double calcul() {
        // Utilise la méthode getValue() de l'implémentation injectée de IDao
        // et multiplie le résultat par 2
        return dao.getValue() * 2;
    }

    // Setter pour l'injection par setter (alternative à l'injection par champ)
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    //postconstruct
    @PostConstruct
    private void init() {
        System.out.println("[TRACE] DAO injecté = " + dao.getClass().getSimpleName());
    }
}
