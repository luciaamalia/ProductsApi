package com.products.Products.exceptions;

public class ProductExceptions {

    public class ProductAlreadyExistsException extends RuntimeException {
        public ProductAlreadyExistsException(String message) {
            super(message);
        }
    }

    public class InvalidIdFormatException extends RuntimeException {
        public InvalidIdFormatException(String message) {
            super(message);
        }
    }

    public class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public class InvalidFieldFormatException extends RuntimeException {
        public InvalidFieldFormatException(String fieldName) {
            super("O campo " + fieldName + " está com um formato inválido");
        }
    }

    public class InvalidDataFormatException extends RuntimeException {
        public InvalidDataFormatException(String message) {
            super("Formato de dados inválido");
        }
    }

    public class RequiredFieldMissingException extends RuntimeException {
        public RequiredFieldMissingException(String fieldName) {
            super("O campo " + fieldName + " é obrigatório");
        }
    }

}
