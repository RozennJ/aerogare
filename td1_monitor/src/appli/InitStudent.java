package appli;

import engine.EntiteSimulee;
import engine.InitData;
import enstabretagne.base.time.LogicalDateTime;

public abstract class InitStudent extends InitData{
    String name;
    String genre;
    String favoriteMovie;


    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public InitStudent() {
        this.name = name;
        this.genre = genre;
        this.favoriteMovie = favoriteMovie;



    }



}
