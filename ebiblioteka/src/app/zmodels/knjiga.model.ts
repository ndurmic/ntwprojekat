export class Knjiga {
    public naziv: string;
    public opis: string;
    public imagePath: string;

    constructor(naziv: string, opis: string, imagePath: string){
        this.naziv=naziv;
        this.opis=opis;
        this.imagePath=imagePath;
    }
}