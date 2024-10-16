package com.products.Products.validations;

import com.products.Products.exceptions.ProductExceptions;
import org.springframework.stereotype.Component;

@Component
public class ProductValidations {
    public void validateProduct(Product product) {
        // Validação de campos obrigatórios
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new ProductExceptions.RequiredFieldMissingException("name");
        }
        if (product.getPrice() == null) {
            throw new ProductExceptions.RequiredFieldMissingException("price");
        }
        if (product.getTypeProduct() == null || product.getTypeProduct().isEmpty()) {
            throw new ProductExceptions.RequiredFieldMissingException("typeProduct");
        }
    }

    public void validateId(String id) {
        // Validação de formato do ID
        if (!isValidIdFormat(id)) {
            throw new ProductExceptions.InvalidIdFormatException("O formato do ID está incorreto");
        }

        // Aqui você também pode verificar se o ID existe no banco
        // if (!productRepository.existsById(id)) {
        //     throw new ProductNotFoundException("Produto não encontrado");
        // }
    }

    private boolean isValidIdFormat(String id) {
        // Exemplo simples de validação (ajuste conforme necessário)
        return id != null && id.matches("\\d+");
    }

    public void validateFieldFormat(String fieldName, Object value) {
        // Aqui você pode adicionar lógica para validar formatos específicos
        if (value == null) {
            throw new InvalidFieldFormatException(fieldName);
        }
        // Exemplos adicionais de validação podem ser implementados conforme necessário
    }

    public void validateRequestBody(Object body) {
        // Valida se o corpo da requisição está em um formato correto
        if (body == null) {
            throw new ProductExceptions.InvalidDataFormatException("Formato de dados inválido");
        }
    }
}
