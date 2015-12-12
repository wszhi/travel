/**
 * 日历
 */

$("#Text2").click(function (e) {
	var ths = this;
	calendar.show({
		id: this, ok: function () {
			alert(ths.value);
		}
	});
});
