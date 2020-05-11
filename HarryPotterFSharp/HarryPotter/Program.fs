type Book = { bookNb: int }

type Basket = { books: Book list }
module Basket =
    let howManyDifferent b =
        List.distinct b.books |> List.length

    let howMany basket book  =
        List.filter ((=) book) basket.books
        |> List.length
    
    let basket books =
        { books = List.map (fun b -> { bookNb = b }) books }

type Discount = {
    nbBook: int
    ratio: float
}

module Discount =
    let canBeApplied b d =
        Basket.howManyDifferent b >= d.nbBook

    let apply price d =
        price * (float d.nbBook) * d.ratio

    let removeFirstOccurence l o =
        let rec doRemove acc l =
            match l with
            | [] -> acc
            | (hd::tl) -> if hd = o
                          then List.append acc tl
                          else doRemove (hd::acc) tl
        let res = doRemove [] l
        res

    let removePaidBooks b d =
        let booksToRemove =
            List.distinct b.books
            |> List.sortBy (Basket.howMany b)
            |> List.rev
            |> List.take d.nbBook
        
        { books = List.fold removeFirstOccurence b.books booksToRemove }

module Cashier =     
    let private findAvailableDiscount d b =
        List.filter (Discount.canBeApplied b) d

    let rec compute price discounts basket =
        match basket.books with
        | [] -> 0.0
        | _ ->
            match findAvailableDiscount discounts basket with
            | [] -> price * (List.length basket.books |> float)
            | availables ->
                List.map (computeDiscount price discounts basket) availables
                |> List.min
    
    and private computeDiscount price discounts basket discount =
        let local = Discount.apply price discount
        let remaining = Discount.removePaidBooks basket discount
        local + compute price discounts remaining



[<EntryPoint>]
let main argv = 
    let price = 8.0
    let discounts = [{ nbBook = 2; ratio = 0.95}
                     { nbBook = 3; ratio = 0.9}
                     { nbBook = 4; ratio = 0.8}
                     { nbBook = 5; ratio = 0.75}]
    let compute = Cashier.compute price discounts

    compute (Basket.basket [1;1;2;2;3;3;4;5])
    |> printfn "%A" 
    
    System.Console.ReadKey false |> ignore
    0 // return an integer exit code
