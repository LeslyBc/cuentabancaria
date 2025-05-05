package org.example;

public class CuentaCorriente extends  CuentaBancaria{
    /*variable float de sobregiro */
    private float sobregiro = 0;
    /*creamos el constructor */
    public CuentaCorriente(float saldo, float tasaAnual){
        super (saldo, tasaAnual);

    }
    /*método para retirar*/
    public void retirar(float cantidad) {
        /*si la cantidad a retirar es menor o igual al saldo llamamos al metodo de la clase padre*/
        if (cantidad <= saldo) {
            super.retirar(cantidad);
            /*de otra manera calculamos el sobregiro y hacemos el retiro con esos datos*/
        } else {
            /*sobregiro restando el saldo a la cantidad a retirar */
            sobregiro = sobregiro + (cantidad - saldo);
            /*definimos saldo en 0 para que no sea negativo*/
            saldo = 0;
            /*aumentamos el numero de retiros*/
            numeroRetiros++;
        }
    }

    /*método para depositar*/
    public void depositar(float cantidad) {
        /*verificamos si hay sobregiro*/
        if (sobregiro > 0) {
            /*si el cantidad es mayor o igual al sobregiro restamos el sobregiro a la cantidad que se va a depositar y definimos el sobregiro en 0*/
            if (cantidad >= sobregiro) {
                /*restamos el sobregiro*/
                cantidad = cantidad - sobregiro;
                /*definimos el sobregiro en 0*/
                sobregiro = 0;
                /*si no se cumple la condicion anterior definimos el sobregiro restante restando la cantidad que se deposito*/
            } else {
                sobregiro = sobregiro - cantidad;
                /*definimos cantidad en 0 pues no se va a agregar nada a la cuenta*/
                cantidad = 0;
            }
        }
        /*invocamos al metodo heredado*/
        super.depositar(cantidad);
    }
    /*método extractoMensual*/
    public void extractoMensual() {
        /*llamamos al método heredado*/
        super.extractoMensual();

    }
    /*imprimir datos de cuenta y agregar el sobre giro y el total de transacciones*/
    public void imprimir() {
        super.imprimir();
        System.out.println("Sobregiro: " + sobregiro +
                "\nTotal transacciones: " + (numeroConsignaciones + numeroRetiros));
    }
}
