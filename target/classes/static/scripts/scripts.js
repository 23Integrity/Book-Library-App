// Search button event listener
// if user decides to search,
window.addEventListener('DOMContentLoaded', function() {
    const search_btn = document.getElementById('search-btn')
    const categories_btn = document.getElementById('categories-btn')

    search_btn.addEventListener('click', function() {
        window.sessionStorage.setItem('isbn', document.getElementById("search-textarea").value)
    })

    $('#categories-list').change(get_books)
})



// Fetching JSON for a specific book from /details endpoint
function display_book() {
    const url = '/details?'
    let book_isbn = window.sessionStorage.getItem('isbn')
    document.title = 'Error - WTT Library'

    $.getJSON(url + "isbn=" + book_isbn, function (data) {
        document.title = data.title + ' - WTT Library'
        document.querySelector('#cover').src = data.thumbnailUrl
        document.querySelector('#title').innerHTML = data.title

        // Checking if values are present
        if (data.description !== undefined)
            document.querySelector('#description').innerHTML = data.description
        else
            document.querySelector('#description').innerHTML = 'Sorry, no description provided.'

        if (data.publishedDate !== undefined)
            document.querySelector('#date').innerHTML = 'Published date: ' + data.publishedDate
        else
            document.querySelector('#date').innerHTML = 'Sorry, no publishing date provided.'

        if (data.authors[0] !== undefined)
            document.querySelector('#authors').innerHTML = 'Author(s): ' + data.authors
        else
            document.querySelector('#authors').innerHTML = 'Sorry, no authors provided.'
    })
}

// As named - it gets categories
// Also creates HTML elements, corresponding to those categories
function get_categories() {
    const url = '/categories'
    let selection = document.getElementById('categories-list')
    let fragment = document.createDocumentFragment()

    $.getJSON(url, function (data) {
        data.forEach(function(category) {
            let option = document.createElement('option')
            option.innerHTML = category
            option.attributes.value = category
            fragment.appendChild(option)
            selection.appendChild(fragment)
        })
    })
}

function get_books() {
    let category = $('#categories-list option:selected').text()
    let url
    if (category === 'All books')
        url = '/all-books'
    else
        url = '/categories/books?id=' + category
    let list = document.getElementById('book-list')
    let fragment = document.createDocumentFragment()

    $.getJSON(url, function(data) {
        while (list.firstChild) {
            list.removeChild(list.lastChild)
        }
        data.forEach(function(book) {
            let div = document.createElement('div')
            div.id = 'grid-element'

            let a = document.createElement('a')
            a.href = '../html/book.html'
            a.addEventListener('click', function() {
                window.sessionStorage.setItem('isbn', book.isbn)
            })

            let img = document.createElement('img')
            img.src = book.thumbnailUrl

            let header = document.createElement('h5')
                header.innerHTML = book.title

            let author = document.createElement('p')
            if (book.authors[0] !== undefined)
                author.innerHTML = book.authors
            else
                author.innerHTML = 'No authors provided.'

            let publishedDate = document.createElement('p')
            if (book.publishedDate !== undefined)
                publishedDate.innerHTML = book.publishedDate
            else
                publishedDate.innerHTML = 'No date of publishing provided.'

            a.appendChild(img)
            a.appendChild(header)
            a.appendChild(author)
            a.appendChild(publishedDate)

            div.appendChild(a)
            fragment.appendChild(div)
            list.appendChild(fragment)
        })
    })
}

// It gets top authors list and creates elements on the site
function get_top_authors_list() {
    const url = '../top-authors'
    let ol = document.getElementById('top-authors-list')
    let fragment = document.createDocumentFragment()

    $.getJSON(url, function (data) {
        data.forEach(function(author) {
            let li = document.createElement('li')
            li.innerHTML = '<h3>' + author.author + '</h3>' + '<p>Rating: ' + author.averageRating + '</p>'
            fragment.appendChild(li)
            ol.appendChild(fragment)
        })
    })
}

