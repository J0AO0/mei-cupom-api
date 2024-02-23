package com.mei.vendasapi.validation.estoque;

import com.mei.vendasapi.domain.Estoque;
import com.mei.vendasapi.domain.dto.EstoqueNewDTO;
import com.mei.vendasapi.repository.EstoqueRepository;
import com.mei.vendasapi.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EstoqueInsertValidator implements ConstraintValidator<EstoqueInsert, EstoqueNewDTO> {

    @Autowired
    private EstoqueRepository repo;
    @Override
    public void initialize(EstoqueInsert ann){

    }

    @Override
    public boolean isValid(EstoqueNewDTO value, ConstraintValidatorContext context) {
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
