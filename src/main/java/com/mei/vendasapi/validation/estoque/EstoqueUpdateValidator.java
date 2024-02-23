package com.mei.vendasapi.validation.estoque;

import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.dto.EstoqueDTO;
import com.mei.vendasapi.repository.EstoqueRepository;
import com.mei.vendasapi.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EstoqueUpdateValidator implements ConstraintValidator<EstoqueUpdate, EstoqueDTO> {
    @Autowired
    private EstoqueRepository repo;
    @Override
    public void initialize(EstoqueUpdate ann){

    }

    @Override
    public boolean isValid(EstoqueDTO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Estoque cat = repo.findByNome(value.getNome());
        if (cat != null) {
            list.add(new FieldMessage("name", " Estoque já existente "));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
