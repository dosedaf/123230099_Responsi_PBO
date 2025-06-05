/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package responsi;

/**
 *
 * @author Lab Informatika
 */

import responsi.view.MainView;
import responsi.model.Kendaraan;
import responsi.controller.KendaraanController;

public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainView view = new MainView();
        Kendaraan model = new Kendaraan();

        new KendaraanController(view, model);

        view.setVisible(true);
    }

}
