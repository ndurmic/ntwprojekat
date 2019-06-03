import { Knjiga } from './knjiga.model';

export class Kolekcija {
    public naziv: string;
    public javna: boolean;
    public knjige: Knjiga[] = [
        new Knjiga('Knjiga 1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://evrobook.rs/fajlovi/product/jezeva-kucica-jezeva-kucica_59c36d949222f.jpg'),
        new Knjiga('Knjiga 1','Lorem ipsum dolor sit amet consectetur adipisicing elit. Velit quos eius id maxime quasi ratione, modi recusandae voluptas necessitatibus dolores labore voluptatem quia repellendus architecto, mollitia quae consequuntur expedita sint?','https://static.lupiga.com/repository/vijesti/slike/20130216105730basta_sljezove_boje.jpg')
      ];
    constructor(naziv: string, javna: boolean){
        this.naziv=naziv;
        this.javna=javna;
    }
}
