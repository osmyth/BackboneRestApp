$.fn.serializeObject = function() {
  var o = {};
  var a = this.serializeArray();
  $.each(a, function() {
      if (o[this.name] !== undefined) {
          if (!o[this.name].push) {
              o[this.name] = [o[this.name]];
          }
          o[this.name].push(this.value || '');
      } else {
          o[this.name] = this.value || '';
      }
  });
  return o;
};

$.ajaxPrefilter( function( options, originalOptions, jqXHR ) {
  options.url = 'http://backbonejs-beginner.herokuapp.com' + options.url;
});

var Users = Backbone.Collection.extend({
  url: '/users'
});


var UserListView = Backbone.View.extend({
    el:'.page',
    var that = this;
    render: function() {
        var users = new Users();
        users.fetch({
            success: function(users) {
            that.$el.html("list view here");
            }
        })
    }
});

var userListView = new UserListView();

var router = new Router;
router.on('route:home', function(){
    userListView.render();
});

router.on('route:edit', function(){
    userEditView.render();
});

Backbone.history.start();