/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saude.configuracao.estilo;

import br.com.saude.model.Horario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tecin
 */
public class HorarioTableModel extends AbstractTableModel {

    private List<Horario> horarios = new ArrayList<>();
    private final String[] colunas = {"Data", "Horarios"};

    @Override
    public int getRowCount() {
        return this.horarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return this.horarios.get(rowIndex).getData().toString();
            case 1:
                return this.horarios.get(rowIndex).getDescricao();
        }
        return null;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
