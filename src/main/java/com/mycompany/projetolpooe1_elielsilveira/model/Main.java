/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.projetolpooe1_elielsilveira.model;

/**
 *
 * @author spiec
 */
package com.mycompany.projetolpooe1_elielsilveira;

import com.mycompany.projetolpooe1_elielsilveira.model.dao.PersistenciaJPA;

public class Main {
    public static void main(String[] args) {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("Conectou no BD via JPA ...");
            jpa.fecharConexao();
        } else {
            System.out.println("Não conectou no BD ...");
        }
    }
}
