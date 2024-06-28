/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo_activos;

/**
 *
 * @author Gabo
 */
import java.util.List;

public class ReporteDepreciacionAcumulada {
    public static void generarReporte(List<Activo> activos, List<DetalleDepreciacion> detallesDepreciacion) {
        for (Activo activo : activos) {
            double depreciacionAcumulada = 0;
            for (DetalleDepreciacion detalle : detallesDepreciacion) {
                if (detalle.getActivo().equals(activo)) {
                    depreciacionAcumulada += detalle.getValorDepreciacion();
                }
            }
            System.out.println("Nombre del activo: " + activo.getNombre());
            System.out.println("Depreciación acumulada: " + depreciacionAcumulada);
        }
    }
}