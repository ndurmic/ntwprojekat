export class Knjiga {
    public naziv: string;
    public opis: string;
    public imagePath: string;
    public id: number;
    public rating: number;

    constructor(id: number, naziv: string, opis: string, imagePath: string, rating: number){
        this.id=id;
        this.naziv=naziv;
        this.opis=opis;
        this.imagePath=imagePath;
        this.rating=rating;
    }
}