package com.api.stock.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoritoDTO {

    private Integer id;

    private String idUsuario;

    private Integer idProduto;
}
