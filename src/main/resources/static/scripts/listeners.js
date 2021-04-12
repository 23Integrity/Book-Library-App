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

