import React, { Component } from 'react';

class MovieForm extends Component {
    constructor(props) {
        super(props);
        const today = new Date();
        const year = today.getFullYear();
        let month = today.getMonth() + 1; // Months are 0-based, so add 1
        let day = today.getDate();

        // Ensure month and day are two digits
        if (month < 10) {
            month = `0${month}`;
        }
        if (day < 10) {
            day = `0${day}`;
        }

        const DateToday = `${year}-${month}-${day}`;
        this.state = {
            title: '',
            date: DateToday,
            trailerLink: '',
            poster: '',
            genres: '',
            backdrops: '',
        };
    }

    handleChange = (e) => {
        const { name, value } = e.target;
        this.setState({ [name]: value });
    };

    handleSubmit = (e) => {
        e.preventDefault();
        const movieData = this.state;
        console.log('Movie Data:', movieData);
    };

    render() {
        return (
            <div style={containerStyle}>
                <h2>New Movie Form</h2>
                <form onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="title">Title</label>
                        <input
                            type="text"
                            className="form-control"
                            style={form_input}
                            id="title"
                            name="title"
                            value={this.state.title}
                            onChange={this.handleChange}
                        />
                    </div>
                    <div className="form-group mt-2">
                        <label htmlFor="genres">date</label>
                        <input
                            type="date"
                            className="form-control"
                            style={form_input}
                            id="date"
                            name="date"
                            value={this.state.date}
                            onChange={this.handleChange}
                        />
                    </div>
                    {/* Add form fields for other movie data */}
                    <button type="submit" className="btn btn-primary mt-3 w-100">
                        Submit
                    </button>
                </form>
            </div>
        );
    }

}
const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    minHeight: '100vh',
};
const form_input = {
    width: "100vh"
}

export default MovieForm;
