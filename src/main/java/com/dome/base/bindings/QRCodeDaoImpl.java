package com.dome.base.bindings;

import com.dome.base.model.QRCode;
import com.dome.base.persistence.AbstractHibernateDao;

import java.util.List;

/**
 * Created by akalamichael on 11/13/16.
 */
public class QRCodeDaoImpl extends AbstractHibernateDao implements QRCodeDao {

    public QRCodeDaoImpl(){
        super();
    }

    @Override
    public List<QRCode> findByList() {
        return super.findList(QRCode.class);
    }

    @Override
    public void save(QRCode qrcode) {
        super.save(qrcode);
    }

}
