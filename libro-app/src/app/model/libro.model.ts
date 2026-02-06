import { Autor } from "../services/autor"
import { Categoria } from "./autor.model"

export interface Libro{
    idLibro: Number
    titulo: string
    editorial: string
    numPaginas: number
    edicion: string
    idioma: string
    fechaPublicacion: Date
    descripcion: string
    tipoPasta: string
    iSBN: string
    numEjemplares: number
    portada: string
    presentacion: string
    precio: number
    categoria: Categoria
    autor: Autor

    [Key: string]: any;
}