/**
 * The Patch for jQuery EasyUI 1.4.1
 */
(function($){
	function setMe(target){
		var opts = $(target).textbox('options');
		var tb = $(target).next();
		tb.removeClass('textbox-disabled textbox-readonly');
		if (opts.readonly){tb.addClass('textbox-readonly')}
		if (opts.disabled){tb.addClass('textbox-disabled')}
	}

	var plugin = $.fn.textbox;
	$.fn.textbox = function(options, param){
		if (typeof options != 'string'){
			return this.each(function(){
				plugin.call($(this), options, param);
				setMe(this);
			})
		} else {
			return plugin.call(this, options, param);
		}
	};
	$.fn.textbox.methods = plugin.methods;
	$.fn.textbox.defaults = plugin.defaults;
	$.fn.textbox.parseOptions = plugin.parseOptions;

	var enable = $.fn.textbox.methods.enable;
	$.fn.textbox.methods.enable = function(jq){
		return jq.each(function(){
			enable.call($.fn.textbox.methods, $(this));
			$(this).next().removeClass('textbox-disabled');
		});
		return enable.call($.fn.textbox.methods, jq);
	};
	var disable = $.fn.textbox.methods.disable;
	$.fn.textbox.methods.disable = function(jq){
		return jq.each(function(){
			disable.call($.fn.textbox.methods, $(this));
			$(this).next().addClass('textbox-disabled');
		});
	};
	var readonly = $.fn.textbox.methods.readonly;
	$.fn.textbox.methods.readonly = function(jq, mode){
		return jq.each(function(){
			readonly.call($.fn.textbox.methods, $(this), mode);
			var tb = $(this).next();
			tb.removeClass('textbox-readonly');
			if ($(this).textbox('options').readonly){
				tb.addClass('textbox-readonly');
			}
		});
	}
	$.extend($.fn.textbox.methods, {
		setValue: function(jq, value){
			return jq.each(function(){
				var opts = $.data(this, 'textbox').options;
				var oldValue = $(this).textbox('getValue');
				$(this).textbox('initValue', value);
				if (oldValue != value){
					opts.onChange.call(this, value, oldValue);
					$(this).closest('form').trigger('_change', [this]);
				}
			});
		}
	});
})(jQuery);

(function($){
	function setMe(target){
		var p = $(target).combo('panel');
		p.panel('options').onClose = function(){
			var target = $(this).panel('options').comboTarget;
			var state = $(target).data('combo');
			if (state){
				state.options.onHidePanel.call(target);
			}
		}
	}
	var plugin = $.fn.combo;
	$.fn.combo = function(options, param){
		if (typeof options != 'string'){
			return this.each(function(){
				plugin.call($(this), options, param);
				setMe(this);
			});
		} else {
			return plugin.call(this, options, param);
		}
	};
	$.fn.combo.methods = plugin.methods;
	$.fn.combo.defaults = plugin.defaults;
	$.fn.combo.parseOptions = plugin.parseOptions;

	$.extend($.fn.combo.methods, {
		setValue: function(jq, value){
			return jq.each(function(){
				$(this).combo('setValues', [value]);
			})
		},
		setValues: function(jq, values){
			return jq.each(function(){
				var target = this;
				var state = $.data(target, 'combo');
				var opts = state.options;
				var combo = state.combo;
				if (!$.isArray(values)){values = values.split(opts.separator)}
				
				var oldValues = $(target).combo('getValues');
				combo.find('.textbox-value').remove();
				var name = $(target).attr('textboxName') || '';
				for(var i=0; i<values.length; i++){
					var input = $('<input type="hidden" class="textbox-value">').appendTo(combo);
					input.attr('name', name);
					if (opts.disabled){
						input.attr('disabled', 'disabled');
					}
					input.val(values[i]);
				}
				
				var changed = (function(){
					if (oldValues.length != values.length){return true;}
					var a1 = $.extend(true, [], oldValues);
					var a2 = $.extend(true, [], values);
					a1.sort();
					a2.sort();
					for(var i=0; i<a1.length; i++){
						if (a1[i] != a2[i]){return true;}
					}
					return false;
				})();
				
				if (changed){
					if (opts.multiple){
						opts.onChange.call(target, values, oldValues);
					} else {
						opts.onChange.call(target, values[0], oldValues[0]);
					}
					$(this).closest('form').trigger('_change', [this]);
				}

			})
		}
	})

})(jQuery);

(function($){
	function setValues(target, values, remainText){
		var opts = $.data(target, 'combobox').options;
		var panel = $(target).combo('panel');
		
		if (!$.isArray(values)){values = values.split(opts.separator)}
		panel.find('div.combobox-item-selected').removeClass('combobox-item-selected');
		var vv = [], ss = [];
		for(var i=0; i<values.length; i++){
			var v = values[i];
			var s = v;
			opts.finder.getEl(target, v).addClass('combobox-item-selected');
			var row = opts.finder.getRow(target, v);
			if (row){
				s = row[opts.textField];
			}
			vv.push(v);
			ss.push(s);
		}
		
		$(target).combo('setValues', vv);
		if (!remainText){
			$(target).combo('setText', ss.join(opts.separator));
		}
	}

	var query = $.fn.combobox.defaults.keyHandler.query;
	$.fn.combobox.defaults.keyHandler.query = function(q){
		query.call(this, q);
		var opts = $(this).combobox('options');
		var vv = $(this).combobox('getValues');
		if (!vv.length){
			if (opts.multiple && !q){
				setValues(this, [], true);
			} else {
				setValues(this, [q], true);
			}
		}
	}
})(jQuery);

(function($){
	var plugin = $.fn.form;
	$.fn.form = function(options, param){
		if (typeof options == 'string'){
			return plugin.call(this, options, param);
		} else {
			return this.each(function(){
				plugin.call($(this), options, param);
				var opts = $(this).form('options');
				$(this).unbind('.form').bind('change.form', function(e){
					if (!$(e.target).hasClass('textbox-text')){
						if (opts.onChange){
							opts.onChange.call(this, e.target);
						}
					}
				}).bind('_change.form', function(e, target){
					if (opts.onChange){
						opts.onChange.call(this, target);
					}
				})
			});
		}
	};
	$.fn.form.methods = plugin.methods;
	$.fn.form.defaults = plugin.defaults;
	$.fn.form.parseOptions = plugin.parseOptions;
})(jQuery);

(function($){
	function setBodySize(target){
		var state = $.data(target, 'datagrid');
		var opts = state.options;
		var dc = state.dc;
		var wrap = state.panel;
		var innerWidth = wrap.width();
		var innerHeight = wrap.height();
		
		var view = dc.view;
		var view1 = dc.view1;
		var view2 = dc.view2;
		var header1 = view1.children('div.datagrid-header');
		var header2 = view2.children('div.datagrid-header');
		var table1 = header1.find('table');
		var table2 = header2.find('table');
		
		// set view width
		view.width(innerWidth);
		var headerInner = header1.children('div.datagrid-header-inner').show();
		view1.width(headerInner.find('table').width());
		if (!opts.showHeader) headerInner.hide();
		view2.width(innerWidth - view1._outerWidth());
		view1.children('div.datagrid-header,div.datagrid-body,div.datagrid-footer').width(view1.width());
		view2.children('div.datagrid-header,div.datagrid-body,div.datagrid-footer').width(view2.width());
		
		// set header height
		var hh;
		header1.add(header2).css('height', '');
		table1.add(table2).css('height', '');
		hh = Math.max(table1.height(), table2.height());
		table1.add(table2).height(hh);
		header1.add(header2)._outerHeight(hh);
		
		// set body height
		dc.body1.add(dc.body2).children('table.datagrid-btable-frozen').css({
			position: 'absolute',
			top: dc.header2._outerHeight()
		});
		var frozenHeight = dc.body2.children('table.datagrid-btable-frozen')._outerHeight();
		var fixedHeight = frozenHeight
				+ view2.children('div.datagrid-header')._outerHeight()
				+ view2.children('div.datagrid-footer')._outerHeight()
				+ wrap.children('div.datagrid-toolbar')._outerHeight();
		wrap.children('div.datagrid-pager').each(function(){
			fixedHeight += $(this)._outerHeight();
		});
		var distance = wrap.outerHeight() - wrap.height();
		var minHeight = wrap._size('minHeight') || '';
		var maxHeight = wrap._size('maxHeight') || '';
		view1.add(view2).children('div.datagrid-body').css({
			marginTop: frozenHeight,
			height: (isNaN(parseInt(opts.height)) ? '' : (innerHeight-fixedHeight)),
			minHeight: (minHeight ? minHeight-distance-fixedHeight : ''),
			maxHeight: (maxHeight ? maxHeight-distance-fixedHeight : '')
		});
		
		view.height(view2.height());
	}
	function setMe(target){
		var state = $.data(target, 'datagrid');
		var opts = state.options;
		var panel = state.panel;
		panel.panel('options').onResize = function(width, height){
			setBodySize(target);
			$(target).datagrid('fitColumns');
			opts.onResize.call(panel, width, height);
		}
	}

	var plugin = $.fn.datagrid;
	$.fn.datagrid = function(options, param){
		if (typeof options != 'string'){
			return this.each(function(){
				plugin.call($(this), options, param);
				setMe(this);
			});
		} else {
			return plugin.call(this, options, param);
		}
	};
	$.fn.datagrid.methods = plugin.methods;
	$.fn.datagrid.defaults = plugin.defaults;
	$.fn.datagrid.parseOptions = plugin.parseOptions;
	$.fn.datagrid.parseData = plugin.parseData;

})(jQuery);

(function($){
	$(document).bind('mousedown.propertygrid', function(e){
		var p = $(e.target).closest('div.datagrid-view,div.combo-panel');
		if (p.length){return;}
		$('.propertygrid').find('.datagrid-f').each(function(){
			var opts = $(this).propertygrid('options');
			opts.editIndex = undefined;
		})
	});
})(jQuery);

(function($){
	function setMe(target){
		var opts = $.data(target, 'treegrid').options;
		var dgOpts = $.data(target, 'datagrid').options;
		opts.columns = dgOpts.columns;
		opts.frozenColumns = dgOpts.frozenColumns;
	}
	
	var plugin = $.fn.treegrid;
	$.fn.treegrid = function(options, param){
		if (typeof options != 'string'){
			return this.each(function(){
				plugin.call($(this), options, param);
				setMe(this);
			});
		} else {
			return plugin.call(this, options, param);
		}
	};
	$.fn.treegrid.methods = plugin.methods;
	$.fn.treegrid.defaults = plugin.defaults;
	$.fn.treegrid.parseOptions = plugin.parseOptions;
	
})(jQuery);

(function($){
	var resizing = false;
	function splitMe(container, region){
		var cc = $(container);
		var handles = '';
		var dir = region;
		if (dir == 'north') handles = 's';
		if (dir == 'south') handles = 'n';
		if (dir == 'east') handles = 'w';
		if (dir == 'west') handles = 'e';
		var pp = cc.layout('panel', region);
		pp.panel('options').split = true;
		var panel = pp.panel('panel');
		panel.addClass('layout-split-'+region);
		panel.resizable({
			disabled:false,
			handles:handles,
			onStartResize: function(e){
				resizing = true;
				
				if (dir == 'north' || dir == 'south'){
					var proxy = $('>div.layout-split-proxy-v', container);
				} else {
					var proxy = $('>div.layout-split-proxy-h', container);
				}
				var top=0,left=0,width=0,height=0;
				var pos = {display: 'block'};
				if (dir == 'north'){
					pos.top = parseInt(panel.css('top')) + panel.outerHeight() - proxy.height();
					pos.left = parseInt(panel.css('left'));
					pos.width = panel.outerWidth();
					pos.height = proxy.height();
				} else if (dir == 'south'){
					pos.top = parseInt(panel.css('top'));
					pos.left = parseInt(panel.css('left'));
					pos.width = panel.outerWidth();
					pos.height = proxy.height();
				} else if (dir == 'east'){
					pos.top = parseInt(panel.css('top')) || 0;
					pos.left = parseInt(panel.css('left')) || 0;
					pos.width = proxy.width();
					pos.height = panel.outerHeight();
				} else if (dir == 'west'){
					pos.top = parseInt(panel.css('top')) || 0;
					pos.left = panel.outerWidth() - proxy.width();
					pos.width = proxy.width();
					pos.height = panel.outerHeight();
				}
				proxy.css(pos);
				
				$('<div class="layout-mask"></div>').css({
					left:0,
					top:0,
					width:cc.width(),
					height:cc.height()
				}).appendTo(cc);
			},
			onResize: function(e){
				if (dir == 'north' || dir == 'south'){
					var proxy = $('>div.layout-split-proxy-v', container);
					proxy.css('top', e.pageY - $(container).offset().top - proxy.height()/2);
				} else {
					var proxy = $('>div.layout-split-proxy-h', container);
					proxy.css('left', e.pageX - $(container).offset().left - proxy.width()/2);
				}
				return false;
			},
			onStopResize: function(e){
				cc.children('div.layout-split-proxy-v,div.layout-split-proxy-h').hide();
				pp.panel('resize',e.data);
				
				cc.layout('resize');
				resizing = false;
				
				cc.find('>div.layout-mask').remove();
			}

		})
	}

	$.extend($.fn.layout.methods, {
		split: function(jq, region){
			return jq.each(function(){
				splitMe(this, region);
				$(this).layout('resize');
			});
		},
		unsplit: function(jq, region){
			return jq.each(function(){
				var p = $(this).layout('panel', region);
				p.panel('options').split = false;
				p.panel('panel').removeClass('layout-split-'+region).resizable({disabled:true});
				$(this).layout('resize');
			})
		}
	})
})(jQuery);

(function($){
	$(document).unbind('.messager').bind('keydown.messager', function(e){
		if (e.keyCode == 27){
			$('body').children('div.messager-window').children('div.messager-body').each(function(){
				$(this).window('close');
			});
		} else if (e.keyCode == 9){
			var win = $('body').children('div.messager-window').children('div.messager-body');
			if (!win.length){return}
			var bc = win.find('.messager-button');
			var input = win.find('.messager-input:focus');
			if (input.length){
				bc.find('.l-btn:first').focus();
				return false;
			} else {
				var btn = bc.find('.l-btn:focus');
				if (btn.length){
					btn.next().focus();
					return false;
				}
			}
		}
	});
	var prompt = $.messager.prompt;
	$.messager.prompt = function(title, msg, fn){
		var win = prompt(title, msg, fn);
		win.find('.messager-input').focus();
		return win;
	};
})(jQuery);
