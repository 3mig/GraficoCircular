package com.idnp.graficocircular;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import android.view.View;

public class GraficoCircular extends View{

    float inicio=0;
    int cordenadaX,coordenadaY;
    int numParticiones;
    int[] datos;
    private int[] colores;

    public GraficoCircular (Context context, int numItems,int[] datos,int[] colores) {
        super(context);
        this.numParticiones=numItems;
        this.datos=datos;
        this.colores=colores;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Backgroud
        canvas.drawColor(Color.WHITE);

        //
        Paint paint = new Paint();

        paint.setAntiAlias(true); //suaviza los bordes de lo que se está dibujando, pero no tiene impacto en el interior de la forma.
        paint.setColor(Color.RED); //Color Paint
        paint.setStyle(Paint.Style.STROKE); //estilo de rellenado
        paint.setStrokeWidth(0);
        paint.setStyle(Paint.Style.FILL);
        float[] valoresEscalados = escala();

        RectF rectF = new RectF(0,0,getWidth(),getWidth());

        paint.setColor(Color.BLACK);
        for(int i=0;i<numParticiones;i++){
            paint.setColor(colores[i]);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawArc(rectF,inicio,valoresEscalados[i],true,paint);
            inicio = inicio + valoresEscalados[i];
        }
        //Circulo central
        Paint cenPaint=new Paint();
        int radius = getWidth()/2-200;
        cenPaint.setStyle(Paint.Style.FILL); //relleno
        cenPaint.setColor(Color.WHITE); //color circulo central
        cordenadaX = getWidth()/2;
        coordenadaY = getWidth()/2;
        canvas.drawCircle(cordenadaX,coordenadaY,radius,cenPaint);
    }
    private float[] escala() {
        float[] valoresEscalados = new float[this.datos.length];
        float total = getTotal(); //Suma total de los datos
        for (int i = 0; i < this.datos.length; i++) {
            valoresEscalados[i] = (this.datos[i] / total) * 360; //Escala de cada valor
        }
        return valoresEscalados;
    }

    private float getTotal() {
        float sumDatos = 0;
        float val =0;
        for(int i=0;i<this.datos.length;i++){
            sumDatos+=this.datos[i];
        }
        return sumDatos;
    }
}
