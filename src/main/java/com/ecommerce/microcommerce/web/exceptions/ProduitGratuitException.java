package com.ecommerce.microcommerce.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.annotations.Api;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
@Api(description="Exception levée lorsque le produit est initialisé avec un prix de vente de 0")
public class ProduitGratuitException extends RuntimeException {

	public ProduitGratuitException(String s) {
        super(s);
    }
	
}
