export class Komentar{
    public id: number;
    public idKorisnika: number;
    public komentar: string;

    constructor(id: number, idKorisnika: number, komentar: string){
        this.id=id;
        this.idKorisnika=idKorisnika;
        this.komentar=komentar;
    }
}