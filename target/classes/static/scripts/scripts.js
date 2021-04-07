const url = '/json/books.json'
let books
let categories

function fetch_data() {
    fetch(url).then((response) => {
        return response.json()
    }).then(function(json) {
        books = json
    }).catch(function(err) {
        console.log(err)
    })
}

for (let i = 0; i < books.items.length; i++) {
    if (books.items[i].category) {
        if (categories.includes(books.items[i].category)) {
            categories.add(books.items[i].category)
        }
    }
}

for (let i = 0; i < 4; i++) {
    let category = document.querySelectorAll('.category-element')
    category[i].innerHTML = categories[i]
}