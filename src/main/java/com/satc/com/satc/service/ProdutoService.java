package com.satc.com.satc.service;
import com.satc.com.satc.Model.Produto;
import com.satc.com.satc.Model.QProduto;
import com.satc.com.satc.Model.Status;
import com.satc.com.satc.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository repository;


    public Produto salvar(Produto entity) {
        return repository.save(entity);
    }


    public List<Produto> buscaTodos() {
        return repository.findAll();
    }


    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Produto alterar(Long id, Produto entity) {
        Optional<Produto> existingProdutoOptional = repository.findById(id);
        if (existingProdutoOptional.isEmpty()){
            throw new NotFoundException("Produto não encontrado");
        }

        Produto existingProduto = existingProdutoOptional.get();

        modelMapper.map(entity, existingProduto);

        return repository.save(existingProduto);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}
