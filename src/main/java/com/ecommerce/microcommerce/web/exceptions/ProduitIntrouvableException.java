package com.ecommerce.microcommerce.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Api(description="Exception levée lorsque le produit n'est pas trouvé")
public class ProduitIntrouvableException extends RuntimeException {

    public ProduitIntrouvableException(String s) {
        super(s);
    }
}
