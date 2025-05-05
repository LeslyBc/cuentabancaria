package org.example;
/*
*desarrollador: Gabriel Salguero, Lesly Becerra, Adrian Falcones
* fecha:01/05/2025
* descripcion: Clase padre de nombre CuentaBancaria
* donde se va a crear metodos de deposito y retiro
 */

public class CuentaBancaria {

    /* Declaramos un atributo de tipo flotante para el saldo */
    protected float saldo;

    /* Atributo de tipo int con nombre numeroConsignaciones CON INICIO DE 0 */
    protected int numeroConsignaciones=0;

    /* Número de retiros de tipo int inicializado en 0 */
    protected int numeroRetiros = 0;

    /* Tasa anual en porcentaje de tipo float */
    protected float tasaAnual;

    /*Comisión mensual con valor inicial 0 de tipo flotante*/
    protected float comisionMensual = 0;

    /*
    *Metodo constructor que recibe una cantidad de dinero.
    *@Param saldo parámetro que define el saldo de la cuenta
    * @Param tasaAnual que define la tasa anual del interes
     */

    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }
    /*
    * Métod para recibir una cantidad de dinero a depositar y actualiza el
    * saldo
    *
    * @param saldo, parametro que define la cantidad de dinero que se deposita
    */
    public void depositar(float cantidad){
        /* Actualizamos el saldo con la cantidad del deposito ¨*/
        saldo = saldo + cantidad;
        /*se actualiza el número de consignaciones*/
        numeroConsignaciones++;
    }
    public void retirar(float cantidad){
        /*comprobar si el retiro es valido*/
        if(cantidad<= saldo){
            /*restar cantidad de retiro del saldo*/
            saldo = saldo - cantidad;
            /*Se actualiza el numero de retiros*/
            numeroRetiros++ ;
        }else {
            /*Si no se cumple la condicion imprimir fondos insuficientes*/
            System.out.println("Fondos insuficientes.");
        }
    }
    /*Calcular Interes Mensual*/
    public void calcularInteresMensual(){
        /*Calcular Interes Mensual*/
        float interesMensual = (tasaAnual/12 )* saldo;
        /*Restar Interes Mensual*/
        saldo = saldo -interesMensual;
    }
    /*Extracto Mensual*/
    public void extractoMensual() {
        /*Resta de la comisionMensual*/
        saldo = saldo - comisionMensual;
        /*invocamos al metodo interes mensual*/
        calcularInteresMensual();
    }
    /*método para imprimir datos de la cuenta*/

    public void imprimir() {
        System.out.println("Saldo: " + saldo +
                "\nConsignaciones: " + numeroConsignaciones +
                "\nRetiros: " + numeroRetiros +
                "\nComisión mensual: " + comisionMensual);
    }
}








