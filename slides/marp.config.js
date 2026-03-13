const { Marp } = require('@marp-team/marp-core');
const highlightLines = require('markdown-it-highlight-lines');

module.exports = {
    engine: (opts) => new Marp(opts).use(highlightLines),
};