<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page of Travel Gig</title>


    <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous"></script>

<%--    Link to the JS directory--%>
    <script type="text/javascript" src="./js/home.js"></script>


    <%--    Link to the CSS directory--%>
    <%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static/css/home.css">--%>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<%--    CDN for jquery UI --%>
<%--    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"--%>
<%--            integrity="sha256-xLD7nhI62fcsEZK2/v8LsBcb4lG7dgULkuXoXB/j91c=" crossorigin="anonymous"></script>--%>

</head>
<body>
    <div align="right">
        <security:authorize access="isAuthenticated()">
            Hi <security:authentication property="principal.username" />
        </security:authorize>
        <a href='/login?logout'><p>${Message}</p></a>
        <a href='/signup'> Sign Up</a>
        <a href='/login'> Log In</a></div>


    <div class="container" style="margin-left:100px">
        <h1>Welcome to Travel Gig</h1>
        <h2>Search your desired hotel</h2>
    </div>

    <div class="container border rounded"
         style="margin:auto;padding:50px;margin-top:50px;margin-bottom:50px">
        <h3>Narrow your search results</h3>
        <div class="form-row">
            <div class="col-3">
                Hotel/City/State/Address <input class="form-control" type="text"
                                                id="searchLocation"
                                                name="searchLocation" required />
            </div>
            <div class="col-2">
                No. Rooms: <input class="form-control" type="number"
                                  id="noRooms" name="noRooms" min="1"
                                  minlength="1" required />
            </div>
            <div class="col-2">
                No. Guests: <input class="form-control" type="number"
                                   id="noGuests" name="noGuests" min="1"
                                   minlength="1" required />
            </div>
            <div class="col">
                Check-In Date: <input type="date" id="checkInDate"
                                      name="checkInDate" required />
            </div>


            <div class="col">
                Check-Out Date: <input type="date" id="checkOutDate"
                                       name="checkOutDate" required />
            </div>
            <input class="btn-sm btn-primary" type="button" id="searchBtn"
                   value="SEARCH" />
        </div>
    </div>

    <div class="row">
        <div class="col-2 border rounded" style="margin-left:50px;padding:25px">

            <br>

            Star Rating:<br>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="star_rating form-check-input"
                           id="1_star_rating" value=1>1
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="star_rating form-check-input"
                           id="2_star_rating" value=2>2
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="star_rating form-check-input"
                           id="3_star_rating" value=3>3
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="star_rating form-check-input"
                           id="4_star_rating" value=4>4
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="checkbox" class="star_rating form-check-input"
                           id="5_star_rating" value=5>5
                </label>
            </div>
            <br><br>

            Range:
            <div class="slidecontainer">
                <input type="range" min="1" max="500" value="500" class="slider"
                       id="priceRange">
                <p>Price: $<span id="priceValue"></span></p>
            </div>

            <%--            Amenities--%>
            <div class="form-check">
                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_swimming_pool" value="Swimming Pool" />
                <label class="form-check-label"
                       for="amenity_swimming_pool">Swimming Pool</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_mini_bar" value="Mini Bar" />
                <label class="form-check-label"
                       for="amenity_mini_bar">Mini Bar</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_restaurant" value="Restaurant" />
                <label class="form-check-label"
                       for="amenity_restaurant">Restaurant</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_garden" value="Garden" />
                <label class="form-check-label"
                       for="amenity_garden">Garden</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_spa" value="Spa" />
                <label class="form-check-label"
                       for="amenity_spa">Spa</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_fitness_center" value="FITNESS CENTER" />
                <label class="form-check-label" for="amenity_fitness_center">Fitness
                                                                             Center</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_parking" value="Parking" />
                <label class="form-check-label"
                       for="amenity_parking">Parking</label><br>

                <input type="checkbox" class="hotel_amenity form-check-input"
                       id="amenity_breakfast" value="BREAKFAST" />
                <label class="form-check-label" for="amenity_breakfast">Breakfast</label><br>


            </div>

            <input style="margin-top:25px" class="btn btn-primary" type="button"
                   id="filterBtn" value="FILTER" />
        </div>


        <div class="col-7 border rounded" style="margin-left:50px;">


            <div id="listHotel" style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica,
            sans-serif'>
                List of Hotels
                <table id="hotelTable"
                       class="table table-striped table-bordered">

                </table>
            </div>

        </div>
    </div>

    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Search Hotel Rooms</h4>
                    <button type="button" class="close" data-dismiss="modal">
                        &times;
                    </button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div class="col">
                        <input class="form-control" type="hidden"
                               id="modal_hotelId" />
                        Hotel Name: <input readonly="true" class="form-control"
                                           type="text" id="modal_hotelName" />
                        No. Guests: <input class="form-control" type="number"
                                           id="modal_noGuests" />
                        Check-In Date: <input class="form-control" type="date"
                                              id="modal_checkInDate" />
                        Check-Out Date: <input class="form-control" type="date"
                                               id="modal_checkOutDate" />
                        Room Type:
                        <select class="form-control" id="select_roomTypes">
                        </select>
                        No. Rooms: <input class="form-control" type="number"
                                          id="modal_noRooms" />
                        <input style="margin-top:25px"
                               class="btn btn-searchHotelRooms form-control btn-primary"
                               type="button" id="" value="SEARCH" />
                    </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger"
                            data-dismiss="modal">Close
                    </button>
                </div>

            </div>
        </div>
    </div>


    <div class="modal" id="bookingHotelRoomModal">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header" style="text-align: center">
                    <h4 class="modal-title">
                        Booking Confirmation Form</h4>
                    <button type="button" class="close" data-dismiss="modal">
                        &times;
                    </button>
                </div>

                <!-- Modal body -->
                <div class="modal-body" id="bookingRoom_modalBody">
                    <div class="col">
                        <div><input class="form-control" type="hidden"
                                    id="booking_hotelId" /></div>
                        <div><input class="form-control" type="hidden"
                                    id="booking_hotelRoomId" /></div>
                        <div class="text-primary" style="font-weight: bold">
                            Hotel Name:
                            <input
                                    readonly="true"
                                    class="form-control" type="text"
                                    id="booking_hotelName" /></div>
                        <div class="text-primary" style="font-weight: bold">
                            Customer Email: <input
                                class="form-control"
                                type="email"
                                id="booking_customerEmail" required placeholder="email@gmail.com"/>
                        </div>

                        <div class="text-primary" style="font-weight: bold">
                            Customer Mobile: <input
                                class="form-control"
                                type="text"
                                id="booking_customerMobile" required placeholder="123-456-7890"/>
                        </div>
                        <div class="text-primary" style="font-weight: bold">No.
                                                                            Guests:
                            <input readonly="true"
                                   class="form-control"
                                   type="number"
                                   id="booking_noGuests" />
                        </div>
                        <br>
                        <div>
                            <table id="guestTable"
                                   class="table table-striped table-bordered">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>FirstName</th>
                                        <th>LastName</th>
                                        <th>Gender</th>
                                        <th>Age</th>
                                    </tr>
                                </thead>

                            </table>

                        </div>
                        <div class="text-primary" style="font-weight: bold">No.
                                                                            Rooms:
                            <input readonly="true"
                                   class="form-control"
                                   type="number"
                                   id="booking_noRooms" /></div>
                        <div class="text-primary" style="font-weight: bold">
                            Check-In Date: <input readonly="true"
                                                  class="form-control"
                                                  type="text"
                                                  id="booking_checkInDate" />
                        </div>
                        <div class="text-primary" style="font-weight: bold">
                            Check-Out Date: <input readonly="true"
                                                   class="form-control"
                                                   type="text"
                                                   id="booking_checkOutDate" />
                        </div>
                        <div class="text-primary" style="font-weight: bold">Room
                                                                            Type:
                            <input readonly="true"
                                   class="form-control" type="text"

                                   id="booking_roomType" /></div>

                        <div class="text-primary" style="font-weight: bold"
                        >Original Price: $<span id="booking_original_price"></span>
                        </div>

                        <div class="text-primary" style="font-weight: bold"
                        >Discount: $<span id="booking_discount"></span>
                        </div>

                        <div class="text-primary"
                             style="font-weight: bold">Booking Total: $<span
                                id="booking_price"></span>
                        </div>

                        <div style='margin-top:20px; text-align: center'>
                            <button
                                    class='btn-confirm-booking btn btn-primary'
                                    id="confirmation-booking">
                                Confirm Booking
                            </button>
                            <button class='btn btn-primary'>Edit</button>
                        </div>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger"
                            data-dismiss="modal">Close
                    </button>
                </div>

            </div>
        </div>
    </div>

</body>


</html>