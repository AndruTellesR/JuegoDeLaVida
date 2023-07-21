public class Juego
{
    Especie [][] especie;
    Especie [][] especie2;
    
    public Juego()
    {
        especie = new Especie[6][6];
        especie2 = new Especie[6][6];
        
        //especie [0][0] = new Especie();
        especie [1][0] = new Especie();
        especie [1][1] = new Especie();
        especie [1][2] = new Especie();
        especie [1][3] = new Especie();
        //mina [1][1] = new Minas();
        //mina [1][2] = new Minas();  
        especie [2][5] = new Especie();
        especie [3][5] = new Especie();
        //mina [2][1] = new Minas();
        especie [4][0] = new Especie();
        especie [4][1] = new Especie();
        especie [4][4] = new Especie();
        especie [5][0] = new Especie();
        especie [5][1] = new Especie();
        //mina [2][3] = new Minas();
    }
    
    public void contador()
    {
        int contador = 0;
        
               
        for(int i = 0; i < especie.length;i++)
        {
            for(int j = 0; j < especie.length;j++)
            {
                contador = especieAbajo(i, j) + especieAdelante(i, j) + especieArriba(i, j) + especieAtras(i, j);
                if(especie[i][j] != null && contador <= 1 && contador >= 4)
                {
                    matar(i,j);
                }
                
                if(especie[i][j] == null && contador == 3)
                {
                    nace(i,j);
                }
                else if(especie[i][j] != null && (contador == 2 || contador == 3))
                {
                    sobrevive(i,j);
                }
            }
        }
    }       
    
    public void matar(int i, int j)
    {
        especie2[i][j] = null;
    }
    
    public void nace(int i, int j)
    {
        especie2[i][j] = new Especie();
    }
    
    public void sobrevive(int i, int j)
    {
        especie2[i][j] = especie[i][j];
    }
    
    public int especieAdelante(int i, int j)
    {
        int contador = 0;
        
        if(j < especie.length - 1)
        {
            contador = especie[i][j+1] != null? 1 : 0;
        }
        
        return contador;
    }
    
    public int especieAtras(int i, int j)
    {
        int contador = 0;
        
        if(j > 0)
        {
            contador = especie[i][j-1] != null? 1 : 0;
        }
        
        return contador;
    }

    public int especieArriba(int i, int j)
    {
        int contador = 0;
        
        if(i > 0)
        {
            contador += especie[i-1][j] != null? 1 : 0;
            contador += this.especieAdelante(i-1, j) == 1? 1 : 0;
            contador += this.especieAtras(i-1, j) == 1? 1 : 0;
        }
        
        return contador;
    }
    
    public int especieAbajo(int i, int j)
    {
        int contador = 0;

        if(i < especie.length - 1)
        {
            contador += especie[i+1][j] != null? 1 : 0;
            contador += this.especieAdelante(i+1, j) == 1? 1 : 0;
            contador += this.especieAtras(i+1, j) == 1? 1 : 0;
        }
        
        return contador;
    }
}