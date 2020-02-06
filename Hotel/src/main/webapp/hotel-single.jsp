<%@ include file="header.jsp" %>


<!-- Header -->
<header class="masthead cabinet-header" style="background-image: url(img/admin-bgs/addHotel.jpg);">
    <div class="container">
        <div class="intro-text">
            <div class="intro-lead-in">Ukraine${Hotel.country}, Lviv${Hotel.city}</div>
            <div class="intro-heading text-uppercase">${Hotel.name}Hotel</div>
        </div>
    </div>
</header>

<div class="cabinet-main-section">
    <div class="container">

        <div class="row">
            <div class="col-md-12 mx-auto pt-5">
                <p class="text-justify">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab deleniti ducimus
                    magnam maxime provident
                    sit suscipit. Adipisci architecto, blanditiis cumque deserunt dolore dolorem, ea explicabo illo in
                    labore minus nemo odio pariatur perferendis praesentium recusandae repellat repudiandae suscipit
                    tempora, voluptates! A accusamus consequatur corporis culpa deleniti dolore est ex expedita fugit
                    ipsum laboriosam laborum magnam magni maxime nihil optio placeat quam quo recusandae repellendus,
                    sunt temporibus ullam veritatis. Aut dolores illo necessitatibus numquam obcaecati. Dolorem
                    doloremque et eveniet facilis fugiat iste odio similique, tempore temporibus totam. Ad amet
                    aspernatur atque eaque, eius, fugiat in inventore modi molestias mollitia nostrum obcaecati
                    provident quae quasi quisquam saepe sed tempore temporibus ullam voluptas. Aliquid amet esse officia
                    reiciendis suscipit unde vel vero voluptate. Adipisci at, dolorem eius inventore, optio perspiciatis
                    praesentium qui rerum sit totam, ut voluptatibus. A accusamus ad aut deserunt dolorem excepturi
                    harum id illum ipsum iure magni necessitatibus nesciunt placeat praesentium provident repudiandae
                    saepe, similique sunt ullam voluptatum! A ad aliquam animi at atque consectetur cupiditate dolorum
                    eos error incidunt inventore ipsum labore magnam magni maxime molestias nam nesciunt odit officiis
                    omnis placeat praesentium provident quod recusandae rem repellendus repudiandae rerum similique sit,
                    tenetur unde vel velit vitae. Incidunt iusto quam sapiente. Accusantium adipisci architecto culpa
                    cum ducimus, ea eos excepturi fuga illum inventore maiores nesciunt non odio officia porro
                    praesentium quae quasi quia quibusdam quos repudiandae ullam velit voluptate voluptates voluptatum.
                    Accusamus aperiam autem eligendi fuga illo in incidunt neque non, officiis repellendus, ut voluptas.
                    Atque culpa eveniet nesciunt quidem rerum sunt ut voluptates! Ad aliquid dicta earum eligendi
                    perspiciatis quisquam sed soluta. Accusamus alias consectetur consequuntur cum cupiditate deleniti
                    dicta et excepturi, hic nam nobis nulla odit quidem reiciendis saepe unde ut. Commodi magni nesciunt
                    nisi totam? Ab cumque illum incidunt modi nam odit, provident? Assumenda at autem corporis culpa cum
                    dicta dolor dolore dolorem dolorum eligendi eos eveniet, illum itaque maiores nam neque odit quas
                    quia quis, quos repellendus sapiente tempore ullam, vero voluptate voluptatem voluptates voluptatum.
                    Incidunt odio perspiciatis quia repudiandae totam. Consectetur, cupiditate dolorem ducimus eaque
                    eligendi error minus placeat quis, quos sequi, suscipit unde. Accusamus atque cupiditate, dicta
                    earum error facilis iste pariatur qui. Architecto assumenda consequuntur culpa dolore, eius eos esse
                    et explicabo fuga illum impedit iusto magnam maiores minus odit quae quam quibusdam quisquam sint
                    veniam. Alias aliquid aperiam assumenda consequuntur deserunt dolore earum eligendi excepturi
                    explicabo fugit id in incidunt iste laboriosam magni maiores minima minus molestias neque nesciunt
                    nisi obcaecati odio officiis optio pariatur porro quasi qui quia quidem quos recusandae repellendus
                    similique tempora ut vitae, voluptates voluptatum. Amet aspernatur debitis deserunt dolore eius
                    eveniet, maxime minus officiis repudiandae tempore! Atque dolorem ipsa maiores molestiae mollitia
                    nobis saepe? Ad doloribus et hic illo molestiae numquam quisquam reiciendis rem, repudiandae
                    tempora? Amet architecto asperiores commodi, cum delectus esse eum eveniet minima officiis,
                    perferendis placeat quia rem totam vel voluptas! Adipisci aliquam animi aperiam beatae corporis,
                    dolorem eius fugiat iure maxime nam neque nobis nostrum quam reprehenderit, sunt suscipit tempora
                    tempore ullam!</p>

            </div>
        </div>

        <div class="col-lg-12 text-center mt-5">
            <h2 class="section-heading text-uppercase mb-5">Hotel statistic</h2>
        </div>

        <!-- Area Chart Example-->
        <div class="card mb-5">
            <div class="card-header">
                <i class="fas fa-chart-area"></i>
                Area Chart Example
            </div>
            <div class="card-body">
                <canvas id="myAreaChart" width="100%" height="30"></canvas>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div>
</div>

<!-- Charts-->
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="js/demo/chart-area-demo.js"></script>

<%@ include file="footer.jsp" %>

