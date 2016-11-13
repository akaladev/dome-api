package com.dome.base.bindings;

import com.dome.base.model.QRCode;

import java.util.List;

/**
 * Created by akalamichael on 11/13/16.
 */
public interface QRCodeDao {
    public List<QRCode> findByList();
    public void save(QRCode qrcode);

}
