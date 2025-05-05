package org.example;

public class CuentaAhorros extends CuentaBancaria {
 /*Declaramos una variable de tipo booleano*/
    private boolean activa;
    /*Creamos el constructor*/
    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        /*desactivar o activar si el saldo es menor a 50*/
        if(saldo<50){
            activa=false;

        }else{
            activa=true;
        }
    }
    /*Implemento un método para depositar*/
    public void depositar(float cantidad){
        if(activa){
            super.depositar(cantidad);
        }
    }
    /*implemento metodo para retirar*/
    public void retirar(float cantidad){
        if (activa){
         super.retirar(cantidad);
        }
    }
    /* metodo calcular extracto mensual*/
    public void extractoMensual() {
        /*Verificar si el numero de retiros es mayor a 4*/
        if (numeroRetiros > 4) {
            /*Calcular la comision mensual en base al numero de adicionales*/
            comisionMensual = comisionMensual + (numeroRetiros - 4) * 10;
        }
        /*llamar al metodo de la clase CuentaBancaria*/
        super.extractoMensual();
        /*verificar si el saldo sigue siento mayor o igual a 50*/
        if (saldo<50){
            activa=false;

        }
    }


}
