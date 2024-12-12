package com.sisuaplication.models.Notas;

import com.sisuaplication.controllers.CalcularNotas;
import com.sisuaplication.models.sistemalogin.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = NotasDoUsuario.TABLE_NAME)
public class NotasDoUsuario {

    public static final String TABLE_NAME = "NotasDoUsuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_login", nullable = false, updatable = false)
    private Usuario usuario;

    @Column(name = "matematica", length = 6, nullable = false)
    @NotBlank(groups = CalcularNotas.class )
    private int matematica;

    
    @Column(name = "ciencias_da_natureza", length = 6, nullable = false)
    @NotBlank(groups = CalcularNotas.class )
    private int cienciasDaNatureza;

    @Column(name = "linguagens", length = 6, nullable = false)
    @NotBlank(groups = CalcularNotas.class )
    private int linguagens;

    @Column(name = "humanas", length = 6, nullable = false)
    @NotBlank(groups = CalcularNotas.class )
    private int humanas;

    @Column(name = "redacao", length = 6, nullable = false)
    @NotBlank(groups = CalcularNotas.class )
    private int redacao;

}
