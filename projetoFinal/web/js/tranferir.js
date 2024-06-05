document.querySelectorAll('.btn-comprar').forEach(btn => {
    btn.addEventListener('click', function () {
        var idProdutos = this.getAttribute('data-id');
        var descricaoCarrinho = this.getAttribute('data-descricao');
        var nomeCarrinho = this.getAttribute('data-nome');
        var precoCarrinho = this.getAttribute('data-preco');
        var imagem = this.getAttribute('data-imagem');


        // Crie um novo objeto FormData
        var formData = new FormData();

        // Adicione os dados do produto ao FormData
        formData.append('idProdutos', idProdutos);
        formData.append('descricaoCarrinho', descricaoCarrinho);
        formData.append('nomeCarrinho', nomeCarrinho);
        formData.append('precoCarrinho', precoCarrinho);


        // Crie um Blob a partir do base64 da imagem
        var byteCharacters = atob(imagem);
        var byteNumbers = new Array(byteCharacters.length);
        for (var i = 0; i < byteCharacters.length; i++) {
            byteNumbers[i] = byteCharacters.charCodeAt(i);
        }
        var byteArray = new Uint8Array(byteNumbers);
        var blob = new Blob([byteArray], {type: 'image/png'});

        // Adicione a imagem ao FormData
        formData.append('imagem', blob, 'imagem.png');

        // Envie o FormData
        fetch('enviarb', {
            method: 'POST',
            body: formData
        })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Ocorreu um erro ao enviar o formulário.');
                    } else {
                        alert('Finalizando Compra.');
                        window.location.href = './Index';
                    }

                })
                .catch(error => {
                    console.error('Erro:', error);
                });
    });
});
