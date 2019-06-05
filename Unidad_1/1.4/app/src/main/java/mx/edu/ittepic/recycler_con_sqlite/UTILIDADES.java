package mx.edu.ittepic.recycler_con_sqlite;

public class UTILIDADES {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="USUARIO";
    public static final String CAMPO_ID="ID";
    public static final String CAMPO_NOMBRE="NOMBRE";
    public static final String CAMPO_CLAVE="CLAVE";
    public static final String CAMPO_TELEFONO="TELEFONO";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CLAVE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";
}
